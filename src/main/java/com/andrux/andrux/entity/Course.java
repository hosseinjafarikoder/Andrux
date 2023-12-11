package com.andrux.andrux.entity;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "COURSE")
@Data
public class Course {

    @Id
    @GeneratedValue
    private Long courseId;
    private String courseName;
    //
    private String description;
    private Long price;
    private Boolean status;
    private Integer rank;
    private String previewImagePath;
    //    @ElementCollection
//    @CollectionTable(name="otherImagePah", joinColumns=@JoinColumn(name="otherImagePah_id"))
//    @Column(name="otherImagePah")
//    private List<String> otherImagePah = new ArrayList<>();
    //todo use upper way or use this way with split with - sign :
    private String otherImagePah;
    private String mentorName;

    //todo : shayad bayad delete konam in ro
    // chon hameye course ha
//    @ManyToOne
//    @JoinColumn(name = "order_entity_id")
//    private Order order;

    @OneToMany(mappedBy="course")
    private List<CourseComment> courseComment = new ArrayList<>();

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "Course_CourseTag",
            joinColumns = { @JoinColumn(name = "course_id") },
            inverseJoinColumns = { @JoinColumn(name = "courseTag_id") }
    )
    private List<CourseTag> courseTag = new ArrayList<>();

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "Course_CourseCategory",
            joinColumns = { @JoinColumn(name = "course_id") },
            inverseJoinColumns = { @JoinColumn(name = "courseCategory_id") }
    )
    private List<CourseCategory> courseCategory = new ArrayList<>();

}
