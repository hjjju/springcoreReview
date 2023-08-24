package hello.core.scan.filter;


import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyExcludeComponet { //얘가 붙은건 컴포넌트 스캔에 제외할거야
    
}
