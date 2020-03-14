package lucencedemo;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * 创建索引
 *
 * @author Yangrj
 * @date 2020/3/12
 */
public class IndexCreate {

    @Test
    public  void createIndex () throws IOException {
        /*1.创建文档对象*/
        Document document = new Document();

        /*2.创建并添加字段信息。参数：字段的名称、字段的值、
            是否存储、这里选store.YES代表存储文档列表，Store.NO代表不存储*/
        document.add(new StringField("id", "1", Field.Store.YES));

        /*3.里我们title字段需要用TextField，即创建索引又会被分词。StringField会创建索引，但是不会被分词*/
        document.add(new TextField("title", "谷歌地图之父跳槽facebook", Field.Store.YES));

        /*4.索引目录类,指定索引在硬盘中的位置*/
        Directory directory = FSDirectory.open(new File("c:\\indexDir"));

        /*5.创建分词器*/
        Analyzer analyzer = new StandardAnalyzer();

        /*6.索引写出工具的配置对象*/
        IndexWriterConfig config = new IndexWriterConfig(Version.LATEST, analyzer);

        /*7.创建缩影的写出工具类。参数：索引的目录和配置信息*/
        IndexWriter indexWriter = new IndexWriter(directory, config);

        /*8.把文档娇给indexWriter*/
        indexWriter.addDocument(document);

        /*9.提交*/
        indexWriter.commit();

        /*10.关闭*/
        indexWriter.close();

    }
}
