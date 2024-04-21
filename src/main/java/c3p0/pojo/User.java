package c3p0.pojo;

import lombok.Data;
import lombok.ToString;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private int uid;
    private String name;
    private String password;
    private String role;
    private String status;
}
