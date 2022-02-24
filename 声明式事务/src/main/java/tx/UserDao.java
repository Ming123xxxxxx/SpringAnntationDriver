package tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * @author 温黎明
 * @version 1.0
 * @date 2021/12/23 12:33
 */
@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insert(){
        String sql ="insert into tb_user (username,age) values (?,?)";
        String substring = UUID.randomUUID().toString().substring(0, 5);
        jdbcTemplate.update(sql,substring,39);
    }
}
