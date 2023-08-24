package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import static org.springframework.context.annotation.ComponentScan.*;

@Configuration //스프링 설정 정보로 인식하고, 스프링빈이 싱글톤을 유지하도록 추가처리를 한다.
@ComponentScan(  //@Configuration이 붙은 설정 정보도 자동으로 등록되기 때문에 excludeFilters를 이용해서 설정정보는 컴포턴트 스캔대에상에서 제외함. 보통은 제외하지않지만 예제코드를 남기기위해.
        excludeFilters = @Filter(type = FilterType.ANNOTATION,classes = Configuration.class)
)
public class AutoAppConfig{


}
