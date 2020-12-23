package dao;

import org.apache.ibatis.annotations.Param;
import vo.AddressVO;

import java.util.List;

public interface AddressDao {
    public List<AddressVO> selectProvinces();
    public List<AddressVO> selectCity(String provinceCode);
    public List<AddressVO> selectArea(String cityCode);
}
