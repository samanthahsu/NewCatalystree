public class UserDataSource implements IUserDataSource {

private UserDAO userDAO;
private static UserDataSource mInstance;

public UserDataSource(UserDAO userDAO) {
this.userDAO = userDAO;
}

public static UserDataSource getInstance(UserDAO userDAO)
{...}

@Override
public Flowable<User> getUserById(int userId) {
return userDAO.getUserById(userId);
}

@Override
public Flowable<List<User>> getAllUsers() {
  return userDAO.getAllUsers();
  }
@Override
public void insertUser(User...users){
}
}
