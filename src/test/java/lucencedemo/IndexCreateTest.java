package lucencedemo;

import org.junit.Test;

import java.io.IOException;

/**
 * 创建索引测试类
 *
 * @author Yangrj
 * @date 2020/3/12
 */
public class IndexCreateTest {

    @Test
    public void test () throws IOException {
        IndexCreate.createIndex();
    }

}
