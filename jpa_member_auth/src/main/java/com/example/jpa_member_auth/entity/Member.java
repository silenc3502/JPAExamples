package com.example.jpa_member_auth.entity;

import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(of="boardNo")
@ToString
@Entity
@Table(name="member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_no")
    private Long memberNo;

    @NotNull
    @Column(length = 64)
    private String userId;

    @NotNull
    @Column(length = 64)
    private String password;

    @CreationTimestamp
    private Date regDate;

    @UpdateTimestamp
    private Date updDate;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "member_no")
    private List<MemberAuth> authList = new ArrayList<MemberAuth>();

    public void addAuth(MemberAuth auth) {
        authList.add(auth);
    }

    public void clearAuthList () {
        authList.clear();
    }
}
