package net.frostcraftsman.gimmickery.proxy;

import cpw.mods.fml.common.registry.LanguageRegistry;


/**
* ���ش���Server�ˣ�
*/
public class GimmickeryCommonProxy {

	/**
	 * ִ�е�1�׶εļ�����Ϊ��
	 */
	public void preInit() {
	    	
	}
	    
	/**
	 * ִ�е�2�׶εļ�����Ϊ��
	 */
	public void init() {
		LanguageRegistry.instance().addStringLocalization("itemGroup.Gimmickery", "����"); //����ģʽ��������
		LanguageRegistry.instance().addStringLocalization("entity.WoodKarakuriNingy.name","ľ����ż");
		LanguageRegistry.instance().addStringLocalization("entity.PrinnyBlue.name","��ɫ������");
	}
	    
	/**
	 * ִ�е�3�׶εļ�����Ϊ��
	 */
	public void postInit() {
		
	}
	
	 public void registerRenderThings() {
     }
     
     public void registerSound() {
     }

		public static Set<String> languages = new HashSet(); 
  
     	static { 
     		languages.add("zh_CN"); 
     		languages.add("en_US"); 
     	} 
     	 
     	public void init() { 
     		for (String lang : languages) { 
     			LanguageRegistry.instance().loadLocalization( 
     					"/assets/gimmickery/lang/" + lang + ".properties", lang, false); 
     		} 
     	} 
}

