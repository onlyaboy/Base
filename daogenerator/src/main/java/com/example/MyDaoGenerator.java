package com.example;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Schema;
import de.greenrobot.daogenerator.Entity;

/**
 * 初始化工作
 * <p/>
 * Created by ChenSL on 2015/8/14.
 */
public class MyDaoGenerator {
    public static void main(String [] args){
        //
        Schema schema = new Schema(1,"com.winston.ljh.base.db");
        //添加表
        addNews(schema);
        addNewsDetail(schema);
        try {
            //C:\Users\OF-G40-449\Desktop\Base\app\src\main\java 是生成代码的路径（网上有人用现对路径，不过我用会报错，所以用了绝对路径）
           //没有使用新建java-gen的方法，直接在java中生成，亲测可以用
            new DaoGenerator().generateAll(schema, "C:\\Users\\OF-G40-449\\Desktop\\Base\\app\\src\\main\\java");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static void addNewsDetail(Schema schema) {
//        Entity newsDetail = schema.addEntity("newsDetail");
//        newsDetail.addIdProperty();
//        newsDetail.addStringProperty("title");
//        newsDetail.addStringProperty("content");

        // 一个实体（类）就关联到数据库中的一张表，此处表名为「Note」（既类名）
        Entity note = schema.addEntity("Note");
        // 你也可以重新给表命名
        // note.setTableName("NODE");

        // greenDAO 会自动根据实体类的属性值来创建表字段，并赋予默认值
        // 接下来你便可以设置表中的字段：
        note.addIdProperty();
        //自增Id  note.addIdProperty().autoincrement();

        //添加字段
        note.addStringProperty("text").notNull();
        // 与在 Java 中使用驼峰命名法不同，默认数据库中的命名是使用大写和下划线来分割单词的。
        // For example, a property called “creationDate” will become a database column “CREATION_DATE”.
        note.addStringProperty("comment");
        note.addDateProperty("date");
    }
    private static void addNews(Schema schema) {
    }
}