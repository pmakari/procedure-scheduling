package com.caresyntax.scheduling.aspect;

import com.caresyntax.scheduling.exception.BeanValidationException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

/**
 * Aspect for checking binding result. Also, I've used an extra annotation
 * (@CheckBindingResult) which should be put above the rests. This annotation
 * makes the aspect flexible, so that we can have a method that has
 * BindingResult and we can handle it and the aspect will not be triggered for
 * that.
 *
 * Created by Parviz on 12.05.2018.
 */
@Component
@Aspect
public class BindingResultAspect {

    @Before("execution (* com.caresyntax.scheduling.controller.*.*(..)) && @annotation (com.caresyntax.scheduling.aspect.CheckBindingResult) && args (..,bindingResult)")
    public void theAdvice(JoinPoint joinPoint, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new BeanValidationException(bindingResult);
        }
    }

}
