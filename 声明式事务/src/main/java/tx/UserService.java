package tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 温黎明
 * @version 1.0
 * @date 2021/12/23 12:33
 */
@Service
public class UserService {

    @Autowired
    private UserDao dao;

    @Transactional
    public  void insertUser(){
        dao.insert();
        System.out.println("插入完成");
        int p=10/0;
    }
}
