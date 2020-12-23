package service;

import vo.AddressVO;
import vo.AdviceVO;

import java.util.List;

public interface AddressService {
    public List<AddressVO> selectProvinces();
    public List<AddressVO> selectCity(String provinceCode);
    public List<AddressVO> selectArea(String cityCode);
}
