package org.alan.license;

import de.schlichtherle.license.LicenseManager;
import de.schlichtherle.license.LicenseParam;

/**
 * @ClassName: LicenseManagerHolder
 * @description: de.schlichtherle.license.LicenseManager的单例
 * @author: AlanMa
 * @create: 2019-06-24 15:14
 */
public class LicenseManagerHolder {

    private static volatile LicenseManager LICENSE_MANAGER;

    public static LicenseManager getInstance(LicenseParam param){
        if(LICENSE_MANAGER == null){
            synchronized (LicenseManagerHolder.class){
                if(LICENSE_MANAGER == null){
                    LICENSE_MANAGER = new CustomLicenseManager(param);
                }
            }
        }

        return LICENSE_MANAGER;
    }

}
