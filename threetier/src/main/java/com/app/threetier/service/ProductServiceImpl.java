package com.app.threetier.service;

import com.app.threetier.domain.vo.ProductVO;
import com.app.threetier.repository.ProductDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductDAO productDAO;

    @Override
    public void registerProduct(ProductVO productVO) {
        productDAO.save(productVO);
    }
}
