package ap.com.httpclient;

/**
 * 类描述：
 * 创建人：swallow.li
 * 创建时间：
 * Email: swallow.li@kemai.cn
 * 修改备注：
 */
public class BaseEntry {

    private int stats;
    private String message;
    private int totalPage;
    private MainBean main;
    private ListBeanX list;
    private String others;
    private String totalPageList;

    public int getStats() {
        return stats;
    }

    public void setStats(int stats) {
        this.stats = stats;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public MainBean getMain() {
        return main;
    }

    public void setMain(MainBean main) {
        this.main = main;
    }

    public ListBeanX getList() {
        return list;
    }

    public void setList(ListBeanX list) {
        this.list = list;
    }

    public String getOthers() {
        return others;
    }

    public void setOthers(String others) {
        this.others = others;
    }

    public String getTotalPageList() {
        return totalPageList;
    }

    public void setTotalPageList(String totalPageList) {
        this.totalPageList = totalPageList;
    }

    public static class MainBean {

        private String merchantId;
        private String id;
        private String loginOper;
        private String name;
        private String email;
        private String mobile;
        private String status;
        private String branchId;
        private String branch;
        private String operType;
        private String password;
        private String roleId;
        private String lastLoginDate;
        private String lastLoginIP;
        private String grantFunc;
        private String tSFlag;
        private String loginTime;
        private String funcGrant;
        private String roleDesc;
        private String openId;
        private String deleteFlag;
        private String takeOutBranchId;
        private String brandName;
        private String macVersion;
        private String discountFlag;
        private int beginDiscount;
        private int endDiscount;

        public String getMerchantId() {
            return merchantId;
        }

        public void setMerchantId(String merchantId) {
            this.merchantId = merchantId;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getLoginOper() {
            return loginOper;
        }

        public void setLoginOper(String loginOper) {
            this.loginOper = loginOper;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getBranchId() {
            return branchId;
        }

        public void setBranchId(String branchId) {
            this.branchId = branchId;
        }

        public String getBranch() {
            return branch;
        }

        public void setBranch(String branch) {
            this.branch = branch;
        }

        public String getOperType() {
            return operType;
        }

        public void setOperType(String operType) {
            this.operType = operType;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getRoleId() {
            return roleId;
        }

        public void setRoleId(String roleId) {
            this.roleId = roleId;
        }

        public String getLastLoginDate() {
            return lastLoginDate;
        }

        public void setLastLoginDate(String lastLoginDate) {
            this.lastLoginDate = lastLoginDate;
        }

        public String getLastLoginIP() {
            return lastLoginIP;
        }

        public void setLastLoginIP(String lastLoginIP) {
            this.lastLoginIP = lastLoginIP;
        }

        public String getGrantFunc() {
            return grantFunc;
        }

        public void setGrantFunc(String grantFunc) {
            this.grantFunc = grantFunc;
        }

        public String getTSFlag() {
            return tSFlag;
        }

        public void setTSFlag(String tSFlag) {
            this.tSFlag = tSFlag;
        }

        public String getLoginTime() {
            return loginTime;
        }

        public void setLoginTime(String loginTime) {
            this.loginTime = loginTime;
        }

        public String getFuncGrant() {
            return funcGrant;
        }

        public void setFuncGrant(String funcGrant) {
            this.funcGrant = funcGrant;
        }

        public String getRoleDesc() {
            return roleDesc;
        }

        public void setRoleDesc(String roleDesc) {
            this.roleDesc = roleDesc;
        }

        public String getOpenId() {
            return openId;
        }

        public void setOpenId(String openId) {
            this.openId = openId;
        }

        public String getDeleteFlag() {
            return deleteFlag;
        }

        public void setDeleteFlag(String deleteFlag) {
            this.deleteFlag = deleteFlag;
        }

        public String getTakeOutBranchId() {
            return takeOutBranchId;
        }

        public void setTakeOutBranchId(String takeOutBranchId) {
            this.takeOutBranchId = takeOutBranchId;
        }

        public String getBrandName() {
            return brandName;
        }

        public void setBrandName(String brandName) {
            this.brandName = brandName;
        }

        public String getMacVersion() {
            return macVersion;
        }

        public void setMacVersion(String macVersion) {
            this.macVersion = macVersion;
        }

        public String getDiscountFlag() {
            return discountFlag;
        }

        public void setDiscountFlag(String discountFlag) {
            this.discountFlag = discountFlag;
        }

        public int getBeginDiscount() {
            return beginDiscount;
        }

        public void setBeginDiscount(int beginDiscount) {
            this.beginDiscount = beginDiscount;
        }

        public int getEndDiscount() {
            return endDiscount;
        }

        public void setEndDiscount(int endDiscount) {
            this.endDiscount = endDiscount;
        }

        @Override
        public String toString() {
            return "MainBean{" +
                    "merchantId='" + merchantId + '\'' +
                    ", id='" + id + '\'' +
                    ", loginOper='" + loginOper + '\'' +
                    ", name='" + name + '\'' +
                    ", email='" + email + '\'' +
                    ", mobile='" + mobile + '\'' +
                    ", status='" + status + '\'' +
                    ", branchId='" + branchId + '\'' +
                    ", branch='" + branch + '\'' +
                    ", operType='" + operType + '\'' +
                    ", password='" + password + '\'' +
                    ", roleId='" + roleId + '\'' +
                    ", lastLoginDate='" + lastLoginDate + '\'' +
                    ", lastLoginIP='" + lastLoginIP + '\'' +
                    ", grantFunc='" + grantFunc + '\'' +
                    ", tSFlag='" + tSFlag + '\'' +
                    ", loginTime='" + loginTime + '\'' +
                    ", funcGrant='" + funcGrant + '\'' +
                    ", roleDesc='" + roleDesc + '\'' +
                    ", openId='" + openId + '\'' +
                    ", deleteFlag='" + deleteFlag + '\'' +
                    ", takeOutBranchId='" + takeOutBranchId + '\'' +
                    ", brandName='" + brandName + '\'' +
                    ", macVersion='" + macVersion + '\'' +
                    ", discountFlag='" + discountFlag + '\'' +
                    ", beginDiscount=" + beginDiscount +
                    ", endDiscount=" + endDiscount +
                    '}';
        }
    }

    public static class ListBeanX {

        private String stats;
        private String message;
        private int totalPage;
        private MainBeanX main;
        private ListBean list;
        private String others;
        private String totalPageList;

        public String getStats() {
            return stats;
        }

        public void setStats(String stats) {
            this.stats = stats;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public int getTotalPage() {
            return totalPage;
        }

        public void setTotalPage(int totalPage) {
            this.totalPage = totalPage;
        }

        public MainBeanX getMain() {
            return main;
        }

        public void setMain(MainBeanX main) {
            this.main = main;
        }

        public ListBean getList() {
            return list;
        }

        public void setList(ListBean list) {
            this.list = list;
        }

        public String getOthers() {
            return others;
        }

        public void setOthers(String others) {
            this.others = others;
        }

        public String getTotalPageList() {
            return totalPageList;
        }

        public void setTotalPageList(String totalPageList) {
            this.totalPageList = totalPageList;
        }

        public static class MainBeanX {
            /**
             * merchantId : 10000604
             * id : 888
             * name : ????
             * addr : ???????yrshdngfc
             * linkman : ???
             * tel : 18300070007
             * startDate : 2017-05-03 00:00:00
             * endDate : 2018-05-03 00:00:00
             * tSFlag : 0
             * maxFlowId :
             * operType :
             * deleteFlag : 0
             * hDXMacId :
             * item :
             * property :
             * weChatBindingFlag : 1
             * alipayBindingFlag : 1
             * longitude :
             * latitude :
             * locationAddr :
             * freeStartDate :
             * freeEndDate :
             * entryFlowId :
             * templateFlowId : 295ab3d6c75343ffa24b9f7e7caeba61
             * templateName :
             */

            private String merchantId;
            private String id;
            private String name;
            private String addr;
            private String linkman;
            private String tel;
            private String startDate;
            private String endDate;
            private String tSFlag;
            private String maxFlowId;
            private String operType;
            private String deleteFlag;
            private String hDXMacId;
            private String item;
            private String property;
            private String weChatBindingFlag;
            private String alipayBindingFlag;
            private String longitude;
            private String latitude;
            private String locationAddr;
            private String freeStartDate;
            private String freeEndDate;
            private String entryFlowId;
            private String templateFlowId;
            private String templateName;

            public String getMerchantId() {
                return merchantId;
            }

            public void setMerchantId(String merchantId) {
                this.merchantId = merchantId;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getAddr() {
                return addr;
            }

            public void setAddr(String addr) {
                this.addr = addr;
            }

            public String getLinkman() {
                return linkman;
            }

            public void setLinkman(String linkman) {
                this.linkman = linkman;
            }

            public String getTel() {
                return tel;
            }

            public void setTel(String tel) {
                this.tel = tel;
            }

            public String getStartDate() {
                return startDate;
            }

            public void setStartDate(String startDate) {
                this.startDate = startDate;
            }

            public String getEndDate() {
                return endDate;
            }

            public void setEndDate(String endDate) {
                this.endDate = endDate;
            }

            public String getTSFlag() {
                return tSFlag;
            }

            public void setTSFlag(String tSFlag) {
                this.tSFlag = tSFlag;
            }

            public String getMaxFlowId() {
                return maxFlowId;
            }

            public void setMaxFlowId(String maxFlowId) {
                this.maxFlowId = maxFlowId;
            }

            public String getOperType() {
                return operType;
            }

            public void setOperType(String operType) {
                this.operType = operType;
            }

            public String getDeleteFlag() {
                return deleteFlag;
            }

            public void setDeleteFlag(String deleteFlag) {
                this.deleteFlag = deleteFlag;
            }

            public String getHDXMacId() {
                return hDXMacId;
            }

            public void setHDXMacId(String hDXMacId) {
                this.hDXMacId = hDXMacId;
            }

            public String getItem() {
                return item;
            }

            public void setItem(String item) {
                this.item = item;
            }

            public String getProperty() {
                return property;
            }

            public void setProperty(String property) {
                this.property = property;
            }

            public String getWeChatBindingFlag() {
                return weChatBindingFlag;
            }

            public void setWeChatBindingFlag(String weChatBindingFlag) {
                this.weChatBindingFlag = weChatBindingFlag;
            }

            public String getAlipayBindingFlag() {
                return alipayBindingFlag;
            }

            public void setAlipayBindingFlag(String alipayBindingFlag) {
                this.alipayBindingFlag = alipayBindingFlag;
            }

            public String getLongitude() {
                return longitude;
            }

            public void setLongitude(String longitude) {
                this.longitude = longitude;
            }

            public String getLatitude() {
                return latitude;
            }

            public void setLatitude(String latitude) {
                this.latitude = latitude;
            }

            public String getLocationAddr() {
                return locationAddr;
            }

            public void setLocationAddr(String locationAddr) {
                this.locationAddr = locationAddr;
            }

            public String getFreeStartDate() {
                return freeStartDate;
            }

            public void setFreeStartDate(String freeStartDate) {
                this.freeStartDate = freeStartDate;
            }

            public String getFreeEndDate() {
                return freeEndDate;
            }

            public void setFreeEndDate(String freeEndDate) {
                this.freeEndDate = freeEndDate;
            }

            public String getEntryFlowId() {
                return entryFlowId;
            }

            public void setEntryFlowId(String entryFlowId) {
                this.entryFlowId = entryFlowId;
            }

            public String getTemplateFlowId() {
                return templateFlowId;
            }

            public void setTemplateFlowId(String templateFlowId) {
                this.templateFlowId = templateFlowId;
            }

            public String getTemplateName() {
                return templateName;
            }

            public void setTemplateName(String templateName) {
                this.templateName = templateName;
            }

            @Override
            public String toString() {
                return "MainBeanX{" +
                        "merchantId='" + merchantId + '\'' +
                        ", id='" + id + '\'' +
                        ", name='" + name + '\'' +
                        ", addr='" + addr + '\'' +
                        ", linkman='" + linkman + '\'' +
                        ", tel='" + tel + '\'' +
                        ", startDate='" + startDate + '\'' +
                        ", endDate='" + endDate + '\'' +
                        ", tSFlag='" + tSFlag + '\'' +
                        ", maxFlowId='" + maxFlowId + '\'' +
                        ", operType='" + operType + '\'' +
                        ", deleteFlag='" + deleteFlag + '\'' +
                        ", hDXMacId='" + hDXMacId + '\'' +
                        ", item='" + item + '\'' +
                        ", property='" + property + '\'' +
                        ", weChatBindingFlag='" + weChatBindingFlag + '\'' +
                        ", alipayBindingFlag='" + alipayBindingFlag + '\'' +
                        ", longitude='" + longitude + '\'' +
                        ", latitude='" + latitude + '\'' +
                        ", locationAddr='" + locationAddr + '\'' +
                        ", freeStartDate='" + freeStartDate + '\'' +
                        ", freeEndDate='" + freeEndDate + '\'' +
                        ", entryFlowId='" + entryFlowId + '\'' +
                        ", templateFlowId='" + templateFlowId + '\'' +
                        ", templateName='" + templateName + '\'' +
                        '}';
            }
        }

        public static class ListBean {
            /**
             * id : 10000604
             * name : ????
             * province : 23
             * city : 385
             * district : 4216
             * industryType : 1
             * industry : 12
             * merchantType : 2
             * linkMan : boss
             * mobile : 18300070007
             * fax :
             * email :
             * address : ?????????????????
             * settleFlag :
             * registerDate : 2017-05-06
             * operId :
             * operDate :
             * status : 1
             * loginTime : 2017-05-03 14:19:33.0
             * tSFlag : 0
             * alipayID :
             * alipayCode :
             * appID :
             * organNo :
             * organName :
             * signature : ???POS?
             * appKey :
             * logisticsNo :
             * tBOrderNo :
             * tBAccount :
             * sMSBanlance : -1
             * sMSScope :
             * xDDAppId : 359012
             * xDDStoreId : 888
             * xDDSignKey : U6WCbHl8j550QeHIcdW53w==
             * assistantId :
             * provinceRegion :
             * cityRegion :
             * districtRegion :
             * originate : 2
             * assistant :
             * hDXMacId :
             * aDHideFlag :
             */

            private String id;
            private String name;
            private String province;
            private String city;
            private String district;
            private String industryType;
            private String industry;
            private String merchantType;
            private String linkMan;
            private String mobile;
            private String fax;
            private String email;
            private String address;
            private String settleFlag;
            private String registerDate;
            private String operId;
            private String operDate;
            private String status;
            private String loginTime;
            private String tSFlag;
            private String alipayID;
            private String alipayCode;
            private String appID;
            private String organNo;
            private String organName;
            private String signature;
            private String appKey;
            private String logisticsNo;
            private String tBOrderNo;
            private String tBAccount;
            private int sMSBanlance;
            private String sMSScope;
            private String xDDAppId;
            private String xDDStoreId;
            private String xDDSignKey;
            private String assistantId;
            private String provinceRegion;
            private String cityRegion;
            private String districtRegion;
            private String originate;
            private String assistant;
            private String hDXMacId;
            private String aDHideFlag;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getProvince() {
                return province;
            }

            public void setProvince(String province) {
                this.province = province;
            }

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public String getDistrict() {
                return district;
            }

            public void setDistrict(String district) {
                this.district = district;
            }

            public String getIndustryType() {
                return industryType;
            }

            public void setIndustryType(String industryType) {
                this.industryType = industryType;
            }

            public String getIndustry() {
                return industry;
            }

            public void setIndustry(String industry) {
                this.industry = industry;
            }

            public String getMerchantType() {
                return merchantType;
            }

            public void setMerchantType(String merchantType) {
                this.merchantType = merchantType;
            }

            public String getLinkMan() {
                return linkMan;
            }

            public void setLinkMan(String linkMan) {
                this.linkMan = linkMan;
            }

            public String getMobile() {
                return mobile;
            }

            public void setMobile(String mobile) {
                this.mobile = mobile;
            }

            public String getFax() {
                return fax;
            }

            public void setFax(String fax) {
                this.fax = fax;
            }

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public String getSettleFlag() {
                return settleFlag;
            }

            public void setSettleFlag(String settleFlag) {
                this.settleFlag = settleFlag;
            }

            public String getRegisterDate() {
                return registerDate;
            }

            public void setRegisterDate(String registerDate) {
                this.registerDate = registerDate;
            }

            public String getOperId() {
                return operId;
            }

            public void setOperId(String operId) {
                this.operId = operId;
            }

            public String getOperDate() {
                return operDate;
            }

            public void setOperDate(String operDate) {
                this.operDate = operDate;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getLoginTime() {
                return loginTime;
            }

            public void setLoginTime(String loginTime) {
                this.loginTime = loginTime;
            }

            public String getTSFlag() {
                return tSFlag;
            }

            public void setTSFlag(String tSFlag) {
                this.tSFlag = tSFlag;
            }

            public String getAlipayID() {
                return alipayID;
            }

            public void setAlipayID(String alipayID) {
                this.alipayID = alipayID;
            }

            public String getAlipayCode() {
                return alipayCode;
            }

            public void setAlipayCode(String alipayCode) {
                this.alipayCode = alipayCode;
            }

            public String getAppID() {
                return appID;
            }

            public void setAppID(String appID) {
                this.appID = appID;
            }

            public String getOrganNo() {
                return organNo;
            }

            public void setOrganNo(String organNo) {
                this.organNo = organNo;
            }

            public String getOrganName() {
                return organName;
            }

            public void setOrganName(String organName) {
                this.organName = organName;
            }

            public String getSignature() {
                return signature;
            }

            public void setSignature(String signature) {
                this.signature = signature;
            }

            public String getAppKey() {
                return appKey;
            }

            public void setAppKey(String appKey) {
                this.appKey = appKey;
            }

            public String getLogisticsNo() {
                return logisticsNo;
            }

            public void setLogisticsNo(String logisticsNo) {
                this.logisticsNo = logisticsNo;
            }

            public String getTBOrderNo() {
                return tBOrderNo;
            }

            public void setTBOrderNo(String tBOrderNo) {
                this.tBOrderNo = tBOrderNo;
            }

            public String getTBAccount() {
                return tBAccount;
            }

            public void setTBAccount(String tBAccount) {
                this.tBAccount = tBAccount;
            }

            public int getSMSBanlance() {
                return sMSBanlance;
            }

            public void setSMSBanlance(int sMSBanlance) {
                this.sMSBanlance = sMSBanlance;
            }

            public String getSMSScope() {
                return sMSScope;
            }

            public void setSMSScope(String sMSScope) {
                this.sMSScope = sMSScope;
            }

            public String getXDDAppId() {
                return xDDAppId;
            }

            public void setXDDAppId(String xDDAppId) {
                this.xDDAppId = xDDAppId;
            }

            public String getXDDStoreId() {
                return xDDStoreId;
            }

            public void setXDDStoreId(String xDDStoreId) {
                this.xDDStoreId = xDDStoreId;
            }

            public String getXDDSignKey() {
                return xDDSignKey;
            }

            public void setXDDSignKey(String xDDSignKey) {
                this.xDDSignKey = xDDSignKey;
            }

            public String getAssistantId() {
                return assistantId;
            }

            public void setAssistantId(String assistantId) {
                this.assistantId = assistantId;
            }

            public String getProvinceRegion() {
                return provinceRegion;
            }

            public void setProvinceRegion(String provinceRegion) {
                this.provinceRegion = provinceRegion;
            }

            public String getCityRegion() {
                return cityRegion;
            }

            public void setCityRegion(String cityRegion) {
                this.cityRegion = cityRegion;
            }

            public String getDistrictRegion() {
                return districtRegion;
            }

            public void setDistrictRegion(String districtRegion) {
                this.districtRegion = districtRegion;
            }

            public String getOriginate() {
                return originate;
            }

            public void setOriginate(String originate) {
                this.originate = originate;
            }

            public String getAssistant() {
                return assistant;
            }

            public void setAssistant(String assistant) {
                this.assistant = assistant;
            }

            public String getHDXMacId() {
                return hDXMacId;
            }

            public void setHDXMacId(String hDXMacId) {
                this.hDXMacId = hDXMacId;
            }

            public String getADHideFlag() {
                return aDHideFlag;
            }

            public void setADHideFlag(String aDHideFlag) {
                this.aDHideFlag = aDHideFlag;
            }

            @Override
            public String toString() {
                return "ListBean{" +
                        "id='" + id + '\'' +
                        ", name='" + name + '\'' +
                        ", province='" + province + '\'' +
                        ", city='" + city + '\'' +
                        ", district='" + district + '\'' +
                        ", industryType='" + industryType + '\'' +
                        ", industry='" + industry + '\'' +
                        ", merchantType='" + merchantType + '\'' +
                        ", linkMan='" + linkMan + '\'' +
                        ", mobile='" + mobile + '\'' +
                        ", fax='" + fax + '\'' +
                        ", email='" + email + '\'' +
                        ", address='" + address + '\'' +
                        ", settleFlag='" + settleFlag + '\'' +
                        ", registerDate='" + registerDate + '\'' +
                        ", operId='" + operId + '\'' +
                        ", operDate='" + operDate + '\'' +
                        ", status='" + status + '\'' +
                        ", loginTime='" + loginTime + '\'' +
                        ", tSFlag='" + tSFlag + '\'' +
                        ", alipayID='" + alipayID + '\'' +
                        ", alipayCode='" + alipayCode + '\'' +
                        ", appID='" + appID + '\'' +
                        ", organNo='" + organNo + '\'' +
                        ", organName='" + organName + '\'' +
                        ", signature='" + signature + '\'' +
                        ", appKey='" + appKey + '\'' +
                        ", logisticsNo='" + logisticsNo + '\'' +
                        ", tBOrderNo='" + tBOrderNo + '\'' +
                        ", tBAccount='" + tBAccount + '\'' +
                        ", sMSBanlance=" + sMSBanlance +
                        ", sMSScope='" + sMSScope + '\'' +
                        ", xDDAppId='" + xDDAppId + '\'' +
                        ", xDDStoreId='" + xDDStoreId + '\'' +
                        ", xDDSignKey='" + xDDSignKey + '\'' +
                        ", assistantId='" + assistantId + '\'' +
                        ", provinceRegion='" + provinceRegion + '\'' +
                        ", cityRegion='" + cityRegion + '\'' +
                        ", districtRegion='" + districtRegion + '\'' +
                        ", originate='" + originate + '\'' +
                        ", assistant='" + assistant + '\'' +
                        ", hDXMacId='" + hDXMacId + '\'' +
                        ", aDHideFlag='" + aDHideFlag + '\'' +
                        '}';
            }
        }

        @Override
        public String toString() {
            return "ListBeanX{" +
                    "stats='" + stats + '\'' +
                    ", message='" + message + '\'' +
                    ", totalPage=" + totalPage +
                    ", main=" + main +
                    ", list=" + list +
                    ", others='" + others + '\'' +
                    ", totalPageList='" + totalPageList + '\'' +
                    '}';
        }
    }
}
