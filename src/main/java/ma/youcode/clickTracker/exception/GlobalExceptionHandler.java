package ma.youcode.clickTracker.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.lang.Nullable;
import org.springframework.web.ErrorResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.AbstractHandlerExceptionResolver;

import java.io.IOException;
import java.util.Map;
import java.util.NoSuchElementException;



public class GlobalExceptionHandler extends AbstractHandlerExceptionResolver {

    private final ObjectMapper mapper = new ObjectMapper();

    @Nullable
    @Override
    protected ModelAndView doResolveException(HttpServletRequest request,
                                              HttpServletResponse response,
                                              @Nullable Object handler,
                                              Exception ex) {

        int status;
        String message;

        if(ex instanceof NoSuchElementException){
            status = 404;
            message = ex.getMessage();
        }else if(ex instanceof IllegalArgumentException) {
            status = 400;
            message = ex.getMessage();
        }else if(ex instanceof ErrorResponse){
            return null;
        }else{
            status = 500;
            message = "Erreur interne du serveur";
        }

            response.setStatus(status);
            response.setContentType("application/json;charset=UTF-8");

            try{

                mapper.writeValue(
                        response.getWriter(),
                        Map.of("error",
                                message != null ? message : "Erreur")
                );
            }catch (IOException e){
                throw new IllegalStateException("Erreur d'ecreture JSON", e);
            }
            return new ModelAndView();

    }
}
