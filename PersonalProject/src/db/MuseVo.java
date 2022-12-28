package db;

public class MuseVo {
	private String BIZPLC_NM;
	private String MUSEUM_ARTGLRY_TYPE_NM;
	private String SIGUN_NM;
	private String REFINE_ROADNM_ADDR;
	private String BSN_STATE_NM;

	public MuseVo() {
		super();
	}

	public MuseVo(String BIZPLC_NM, String SIGUN_NM, String BSN_STATE_NM, String LOCPLC_FACLT_TELNO,
			String REFINE_ROADNM_ADDR, String MUSEUM_ARTGLRY_TYPE_NM) {
		super();
		this.BIZPLC_NM = BIZPLC_NM;
		this.MUSEUM_ARTGLRY_TYPE_NM = MUSEUM_ARTGLRY_TYPE_NM;
		this.SIGUN_NM = SIGUN_NM;
		this.REFINE_ROADNM_ADDR = REFINE_ROADNM_ADDR;
		this.BSN_STATE_NM = BSN_STATE_NM;
	}

	public String getBIZPLC_NM() {
		return BIZPLC_NM;
	}

	public void setBIZPLC_NM(String BIZPLC_NM) {
		this.BIZPLC_NM = BIZPLC_NM;
	}

	public String getMUSEUM_ARTGLRY_TYPE_NM() {
		return MUSEUM_ARTGLRY_TYPE_NM;
	}

	public void setMUSEUM_ARTGLRY_TYPE_NM(String MUSEUM_ARTGLRY_TYPE_NM) {
		this.MUSEUM_ARTGLRY_TYPE_NM = MUSEUM_ARTGLRY_TYPE_NM;
	}

	public String getSIGUN_NM() {
		return SIGUN_NM;
	}

	public void setSIGUN_NM(String SIGUN_NM) {
		this.SIGUN_NM = SIGUN_NM;
	}

	public String getREFINE_ROADNM_ADDR() {
		return REFINE_ROADNM_ADDR;
	}

	public void setREFINE_ROADNM_ADDR(String REFINE_ROADNM_ADDR) {
		this.REFINE_ROADNM_ADDR = REFINE_ROADNM_ADDR;
	}

	public String getBSN_STATE_NM() {
		return BSN_STATE_NM;
	}

	public void setBSN_STATE_NM(String BSN_STATE_NM) {
		this.BSN_STATE_NM = BSN_STATE_NM;
	}

}