import com.kakayunmu.util.sql.BuilderQuery;
import com.kakayunmu.util.sql.model.SqlRetModel;
import com.kakayunmu.util.sql.param.CompareEnum;
import com.kakayunmu.util.sql.param.ParamQuery;
import org.junit.Assert;
import org.junit.Test;


public class BuilderQueryTest {
    @Test
    public void buildSqlStrTest() throws Exception {
        BuilderQuery builderQuery=new BuilderQuery();
        String ret= builderQuery.buildSqlStr(new ParamQuery().from("view_userInfo")
        .andWhere("id","123",CompareEnum.EQUAL)
        .orderBy(" createTime desc ")
        .select("id,userName"));
        System.out.println(ret);
        Assert.assertNotNull(ret);
    }

    @Test
    public void buildSqlTest() throws Exception {
        BuilderQuery builderQuery=new BuilderQuery();
        SqlRetModel retModel= builderQuery.buildSql(new ParamQuery().from("sys_userInfo")
                .select("id")
                .andWhereSql("id='1'")
                .andWhere("userName","张三")
                .orWher("userName","李四"));
        System.out.println(retModel.getSqlStr());
        System.out.println(String.join(",",retModel.getParameters()));
        Assert.assertNotNull(retModel);
    }

    @Test
    public void buildSqlTest2() throws Exception {
        BuilderQuery builderQuery=new BuilderQuery();
        String retStr= builderQuery.buildSqlStr(new ParamQuery().from("sys_userInfo")
                .select("id")
                .andWhereSql("id='1'")
                .andWhere("userName","张三")
                .orWher("userName","李四"));
        System.out.println(retStr);
        Assert.assertNotNull(retStr);
    }
}
