package com.none.authcenter.utils;

import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.hibernate.validator.HibernateValidator;


public class ValidateUtils {
		/**
	 * 使用hibernate的注解来进行验证
	 * 
	 */
	private static Validator validator = Validation
			.byProvider(HibernateValidator.class).configure().failFast(true).buildValidatorFactory().getValidator();

	public static Boolean checkIsNull(Object... objs) {
		for (Object obj : objs) {
			if (obj == null || "".equals(obj)) {
				return true;
			}
		}
		return false;
	}
    /**
     * 功能描述: <br>
     * 〈注解验证参数〉
     *
     * @param obj
     * @throws Exception
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static <T> void validate(T obj) throws Exception {
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(obj);
        // 抛出检验异常
        if (constraintViolations.size() > 0) {
            throw new Exception(String.format("校验失败:%s", constraintViolations.iterator().next().getMessage()));
        }
    }
}
