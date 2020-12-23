package controller;

import common.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.AddressService;
import vo.AddressVO;

import java.util.List;

@Component
@RequestMapping("/address")
public class AddressControlelr {
    @Autowired
    private AddressService addressService;
    @RequestMapping("/province.do")
    @ResponseBody
    public JsonResult province(){
        List<AddressVO> addressVOS = addressService.selectProvinces();
        return new JsonResult(1,addressVOS);
    }

    @RequestMapping("/city.do")
    @ResponseBody
    public JsonResult city(String provinceCode){
        List<AddressVO> addressVOS = addressService.selectCity(provinceCode);
        return new JsonResult(1, addressVOS);
    }

    @RequestMapping("/area.do")
    @ResponseBody
    public JsonResult area(String cityCode){
        List<AddressVO> addressVOS = addressService.selectArea(cityCode);
        return new JsonResult(1,addressVOS);
    }
}
