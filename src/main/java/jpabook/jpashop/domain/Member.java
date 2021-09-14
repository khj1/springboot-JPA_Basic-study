package jpabook.jpashop.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Member {

    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    private String name;

    private String city;

    private String street;

    private String zipcode;

    /*
     이건 좋은 설계가 아니다.
     멤버 엔티티엔 최대한 멤버에 관련된 데이터만 담겨있는 것이 좋다.
     주문 조회는 Order 엔티티에서 이루어져도 아무런 문제가 없다.
     */
    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();
}
