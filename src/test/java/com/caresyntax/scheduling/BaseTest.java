package com.caresyntax.scheduling;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.transaction.Transactional;

/**
 * Base Test for all the test classes. By, default every query will be rolled
 * back because of @Transactional To run real/integration test change the
 * profile to dev
 *
 * Created by Parviz on 10.05.2018.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationBootstrap.class)
@Transactional
@ActiveProfiles("test")
public class BaseTest {

    @Autowired
    private WebApplicationContext context;

    @Autowired
    protected JdbcTemplate jdbcTemplate;

    protected MockMvc mvc;

    @Before
    public void setUp() {
        this.mvc = MockMvcBuilders.webAppContextSetup(this.context).build();
    }

    @Test
    public void test() {
    }

}
