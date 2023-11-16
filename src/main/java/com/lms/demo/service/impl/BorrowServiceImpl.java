package com.lms.demo.service.impl;


import com.lms.demo.dao.BorrowMapper;
import com.lms.demo.pojo.Borrow;
import com.lms.demo.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BorrowServiceImpl implements BorrowService {
    @Autowired
    BorrowMapper mapper;
    @Override
    public List<Borrow> getAllBorrowInfo() {
        return mapper.getAll();
    }

    @Override
    public boolean deleteBorrowInfo(String id) {
        return mapper.deleteById(id)==1;
    }

    @Override
    public boolean addBorrowInfo(String bid, String sid) {
        return mapper.add(bid,sid)==1;
    }
}
