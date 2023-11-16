package com.lms.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Borrow {
    int id;
    int bid;
    String bookName;
    int sid;
    String studentName;
    String time;
}
