package CiroVitiello.U5W2D2.entities;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class Author {
    private long id;
    private String name;
    private String surname;
    private String email;
    private LocalDate birthDate;
    @Setter(AccessLevel.NONE)
    private String avatar;

    public Author(String name, String surname, String email, LocalDate birthDate) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.birthDate = birthDate;
        setAvatar();
    }

    public void setAvatar() {
        this.avatar = "https://ui-avatars.com/api/?name=" + this.name + "+" + this.surname;
    }
}
