package test;

import java.util.Date;
import java.util.List;

import lombok.Data;

/**
 * @ClassName: DocumentOtcRxSaveUpdateVo
 * @Description:
 * @Author: dengjianhan
 * @Date: 2020/3/2 23:36
 */
@Data
public class DocumentOtcRxSaveUpdateVo {

    private static final long serialVersionUID = -7903513223446243835L;

List<String> aaa;
    /**
     * id
     */
   // private String id;
    /**
     * 产品管理状态 0:失效 1:生效
     */
    private Integer documentStatus;
    /**
     * 批准文号
     */
    private String approveNumber;
    /**
     * 批准日期
     */
    private Date approveTime;
    /**
     * 所属单元id
     */
    private String affiliatedUnitId;
    /**
     * 产品名称
     */
    private String productName;
    /**
     * 药品规格
     */
    private String drugStandard;
    /**
     * 生产单位
     */
    private String productUnit;
    /**
     * 剂型
     */
    private String dosageForm;
    /**
     * 同品种数(同品规数)
     */
    private Integer kindCount;
    /**
     * 处方(主料)
     */
    private String mainPrescription;
    /**
     * 处方(辅料)
     */
    private String subsidiaryPrescription;
    /**
     * OTC/Rx/双跨
     */
    private String type;
    /**
     * 基药
     */
    private String basicMedicine;
    /**
     * 医保
     */
    private String healthInsurance;
    /**
     * 有效期
     */
    private String effectiveTime;
    /**
     * 适应症
     */
    private String indication;
    /**
     * 执行标准(历史标准)
     */
    private String executiveStandardHistory;
    /**
     * 执行标准(现行标准)
     */
    private String executiveStandardNow;
    /**
     * 是否在产(五年内)
     */
    private Integer production;
    /**
     * 产量/年
     */
    private Integer yield;
    /**
     * 包装信息(包装规格)
     */
    private String packInfoStandard;
    /**
     * 包装信息(品牌使用情况)
     */
    private String packInfoBrand;
    /**
     * 法定工艺
     */
    private String craft;
    /**
     * 关键设备
     */
    private String keyEquipment;
    /**
     * 年度质量回顾
     */
    private String qualityReview;
    /**
     * 版本号id
     */
    private String versionId;
    /**
     * 版本创建时间
     */
    private Date versionCreateTime;
    /**
     * 附件(多个用;号隔开)
     */
    private String attachment;
    /**
     * 状态 0:历史 1:正式
     */
    private Integer status;

}
