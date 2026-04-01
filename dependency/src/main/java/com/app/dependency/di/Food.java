package com.app.dependency.di;

import lombok.*;
import org.springframework.stereotype.Component;


@Component
//@Getter
//@Setter
//@ToString
//@EqualsAndHashCode
@Data
//@AllArgsConstructor : 초기화 생성자가 없다면 생성자 주입을 받을수 없다.
public class Food {
    private final Knife knife;

//    public void Food(Knife knife) {
//        this.knife = 주입 받은 new knife()
//    }
}


