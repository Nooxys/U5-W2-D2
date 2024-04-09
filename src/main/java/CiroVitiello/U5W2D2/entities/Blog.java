package CiroVitiello.U5W2D2.entities;

import CiroVitiello.U5W2D2.enums.BlogCategories;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class Blog {
    private long id;
    private BlogCategories category;
    private String name;
    private String cover;
    private String content;
    private int minutesOfLecture;
}
