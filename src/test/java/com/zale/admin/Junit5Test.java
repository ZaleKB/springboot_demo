package com.zale.admin;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.fail;



// @SpringBootTest
@DisplayName("Junit5 function test")
public class Junit5Test {

    @Autowired
    JdbcTemplate jdbcTemplate;

    /**
     * ����ǰ������
     */
    @DisplayName("����ǰ������")
    @Test
    void testAssumptions(){
        Assumptions.assumeTrue(false,"�������true");
        System.out.println("111111");

    }
    /**
     * ���ԣ�ǰ�����ʧ�ܣ�����Ĵ��붼����ִ��
     */
    @DisplayName("���Լ򵥶���")
    @Test
    void testSimpleAssertions() {
        int cal = cal(3, 2);
        //���
        assertEquals(6, cal, "ҵ���߼�����ʧ��");
        Object obj1 = new Object();
        Object obj2 = new Object();
        assertSame(obj1, obj2, "��������һ��");

    }

    @Test
    @DisplayName("array assertion")
    void array() {
        assertArrayEquals(new int[]{1, 2}, new int[]{1, 2}, "�������ݲ����");
    }

    @Test
    @DisplayName("��϶���")
    void all() {
        /**
         * ���ж���ȫ����Ҫ�ɹ�
         */
        assertAll("test",
                () -> assertTrue(true && true, "�����Ϊtrue"),
                () -> assertEquals(1, 2, "�������1"));

        System.out.println("=====");
    }

    @DisplayName("�쳣����")
    @Test
    void testException() {

        //�϶�ҵ���߼�һ�������쳣
        assertThrows(ArithmeticException.class, () -> {
            int i = 10 / 2;
        }, "ҵ���߼���Ȼ�������У�");
    }

    @DisplayName("����ʧ��")
    @Test
    void testFail(){
        //xxxxx
        if(1 == 2){
            fail("����ʧ��");
        }

    }


    int cal(int i, int j) {
        return i + j;
    }

    @DisplayName("����displaynameע��")
    @Test
    void testDisplayName() {
        System.out.println(1);
        System.out.println(jdbcTemplate);
    }

    @Disabled
    @DisplayName("���Է���2")
    @Test
    void test2() {
        System.out.println(2);
    }

    @RepeatedTest(5)
    @Test
    void test3() {
        System.out.println(5);
    }

    /**
     * �涨������ʱʱ�䡣����ʱ����Գ��쳣
     *
     * @throws InterruptedException
     */
    @Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
    @Test
    void testTimeout() throws InterruptedException {
        Thread.sleep(600);
    }


    @BeforeEach
    void testBeforeEach() {
        System.out.println("���Ծ�Ҫ��ʼ��...");
    }

    @AfterEach
    void testAfterEach() {
        System.out.println("���Խ�����...");
    }

    @BeforeAll
    static void testBeforeAll() {
        System.out.println("���в��Ծ�Ҫ��ʼ��...");
    }

    @AfterAll
    static void testAfterAll() {
        System.out.println("���в����Լ�������...");

    }
}
