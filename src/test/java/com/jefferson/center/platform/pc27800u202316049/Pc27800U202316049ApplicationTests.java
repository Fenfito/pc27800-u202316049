package com.jefferson.center.platform.pc27800u202316049;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = {
        "spring.datasource.url=jdbc:h2:mem:deliveryorders;DB_CLOSE_DELAY=-1",
        "spring.datasource.driver-class-name=org.h2.Driver",
        "spring.jpa.database=h2",
        "spring.jpa.hibernate.ddl-auto=create-drop"
})
class Pc27800U202316049ApplicationTests {

    @Test
    void contextLoads() {
    }

}
