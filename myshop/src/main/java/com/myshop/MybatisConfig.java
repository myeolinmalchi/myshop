package com.myshop;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@MapperScan(basePackages = {"com.myshop.domain.*.mapper"})
@EnableTransactionManagement
public class MybatisConfig {

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }


    @Bean
    public SqlSessionFactory sqlSessionFactoryBean(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);

//		mapper 파일의 경로를 지정한다.
//		이 프로젝트에서는 [src/main/resources/mapper] 경로로 지정했다.
        bean.setMapperLocations(
                new PathMatchingResourcePatternResolver()
                        .getResources("classpath:mapper/**/*.xml"));

//		mapper 파일에서 엔티티 클래스의 패키지명을 자동으로 인식하는 설정
        bean.setTypeAliasesPackage("com.myshop.domain.*.entity");

        SqlSessionFactory sqlSessionFactory = bean.getObject();
        org.apache.ibatis.session.Configuration configuration = sqlSessionFactory.getConfiguration();

//		DB 테이블의 컬럼과 자바 객체의 인스턴스를 자동으로 매핑해주는 설정
//		스네이크 표기법 <-> 카멜케이스 표기법
        configuration.setMapUnderscoreToCamelCase(true);
        return bean.getObject();
    }

}