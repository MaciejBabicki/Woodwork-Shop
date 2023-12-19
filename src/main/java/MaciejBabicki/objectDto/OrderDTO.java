package MaciejBabicki.objectDto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderDTO {

    private String firstName;
    private String lastName;
    private String street;
    private String postCode;
    private String city;
}
