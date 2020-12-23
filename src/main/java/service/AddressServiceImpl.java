package service;

import dao.AddressDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vo.AddressVO;

import java.util.List;

@Component
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressDao addressDao;
    @Override
    public List<AddressVO> selectProvinces() {
        return addressDao.selectProvinces();
    }

    @Override
    public List<AddressVO> selectCity(String provinceCode) {
        return addressDao.selectCity(provinceCode);
    }

    @Override
    public List<AddressVO> selectArea(String cityCode) {
        return addressDao.selectArea(cityCode);
    }
}
