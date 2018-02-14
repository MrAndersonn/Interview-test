import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AddressDb{

    public AddressDb() {
        try {
            DriverManager.registerDriver(new oracle.jdbc.ThinDriver());
        } catch (ClassNotFoundException e) {
            /*null*/
        }

    }

    public void addPerson(Person person) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:oracle:thin:@prod", "admin", "beefhead");
            statement = connection.prepareStatement("insert into AddressEntry values (?, ?, ?)");
            statement.setLong(1, System.currentTimeMillis());
            statement.setString(2, person.getName());
            statement.setString(3, person.getPhoneNumber().getNumber());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException err) {
                    throw new RuntimeException(err);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException err) {
                    throw new RuntimeException(err);
                }
            }
        }
    }

    /**
     * Looks up the given person, null if not found.
     */
    public Person findPerson(String name) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet result = null;
		
        try {
            connection = DriverManager.getConnection("jdbc:oracle:thin:@prod", "admin", "beefhead");
            statement = connection.prepareStatement("select * from AddressEntry where name = '" + name + "'");
            result = statement.executeQuery();
			
            while (result.next()) {
                String foundName = result.getString("name");
                PhoneNumber phoneNumber = new PhoneNumber(result.getString("phoneNumber"));
				
                return new Person(foundName, phoneNumber);
            }
        }  catch (SQLException e) {
            return null;
        } finally {
            if (result != null) {
                try {
                    result.close();
                } catch (SQLException err) {
                    throw new RuntimeException(err);
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException err) {
                    throw new RuntimeException(err);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException err) {
                    throw new RuntimeException(err);
                }
            }
        }
        return null;
    }

    public List<Person> getAll() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet result = null;

        try {
            connection = DriverManager.getConnection("jdbc:oracle:thin:@prod", "admin", "beefhead");
            statement = connection.prepareStatement("select * from AddressEntry");
            result = statement.executeQuery();

            List<Person> entries = new LinkedList<Person>();

            while (result.next()) {
                String name = result.getString("name");
                PhoneNumber phoneNumber = new PhoneNumber(result.getString("phoneNumber"));
                Person person = new Person(name, phoneNumber);
				person.setDate(new Date(result.getString("date")));
                entries.add(person);
            }

            return entries;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (result != null) {
                try {
                    result.close();
                } catch (SQLException err) {
                    throw new RuntimeException(err);
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException err) {
                    throw new RuntimeException(err);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException err) {
                    throw new RuntimeException(err);
                }
            }
        }
    }

}
