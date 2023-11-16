package com.lms.demo.service;



import com.lms.demo.pojo.Borrow;

import java.util.List;

public interface BorrowService {
    List<Borrow> getAllBorrowInfo();
    boolean deleteBorrowInfo(String id);
    boolean addBorrowInfo(String bid,String sid);
}
