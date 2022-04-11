package cmpmemberapi.domain;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Member extends BaseTimeEntity {

    @Id
    @Column(name = "MEMBER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 255, nullable = false)
    private String name;

    @Column(length = 255, nullable = false, unique = true)
    private String account;

    @Column(length = 255, nullable = false)
    private String password;

    @Column
    @Enumerated(EnumType.STRING)
    private MemberRole memberRole;

    @ManyToMany
    @Column
    @JoinTable(name = "MEMBER_ORGANIZATION",
            joinColumns = @JoinColumn(name = "MEMBER_ID"),
            inverseJoinColumns = @JoinColumn(name = "ORGANIZATION_ID")
    )
    private List<Organization> organizations = new ArrayList<>();

    @ManyToMany
    @Column
    @JoinTable(name = "MEMBER_PROJECT",
            joinColumns = @JoinColumn(name = "MEMBER_ID"),
            inverseJoinColumns = @JoinColumn(name = "PROJECT_ID")
    )
    private List<Project> projects = new ArrayList<>();

    public Member() {
    }

    @Builder
    public Member(Long id, String name, String account, String password, MemberRole memberRole, List<Organization> organizations, List<Project> projects) {
        this.id = id;
        this.name = name;
        this.account = account;
        this.password = password;
        this.memberRole = memberRole;
        this.organizations = organizations;
        this.projects = projects;
    }

}