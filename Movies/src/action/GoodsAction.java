package action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Cate;
import model.Goods;

import org.apache.struts2.ServletActionContext;

import util.CreateId;

import com.opensymphony.xwork2.ActionSupport;

import dao.CateDAO;
import dao.GoodsDAO;

public class GoodsAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private Goods goods;
	private List<Goods> goodsList = new ArrayList<Goods>();
	private String msg;
	private String name;
	private String cond;
	private int pageCur;
	private int totalCount = 0;
	private int totalPage = 0;
	private Map<String, Object> map = new HashMap<String, Object>();
	// 封装上传文件域的属性
	private File image;
	private String imageContentType;
	private String imageFileName;

	private String getSavePath() throws Exception {
		return ServletActionContext.getServletContext().getRealPath("/upfiles");
	}

	private void close(FileOutputStream fos, FileInputStream fis) {
		if (fis != null) {
			try {
				fis.close();
			} catch (IOException e) {
				System.out.println("FileInputStream关闭失败");
				e.printStackTrace();
			}
		}
		if (fos != null) {
			try {
				fos.close();
			} catch (IOException e) {
				System.out.println("FileOutputStream关闭失败");
				e.printStackTrace();
			}
		}
	}

	public String createGoods() {
		CateDAO cateDAO = new CateDAO();
		List<Cate> cateList = new ArrayList<Cate>();
		try {
			cateList = cateDAO.queryAll();
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
		this.map.put("cateList", cateList);
		return SUCCESS;
	}

	public String addGoods() {
		GoodsDAO goodsDAO = new GoodsDAO();
		this.goods.setGoodsid(CreateId.getId());
		this.goods.setSellnum("0");
		FileOutputStream fos = null;
		FileInputStream fis = null;
		int i = getImageFileName().indexOf(".");
		String name = String.valueOf(CreateId.getId());
		String type = getImageFileName().substring(i + 1);
		this.setImageFileName(name + "." + type);
		try {
			// 建立文件输出流
			fos = new FileOutputStream(getSavePath() + "\\" + getImageFileName());
			// 建立文件上传流
			fis = new FileInputStream(this.getImage());
			byte[] buffer = new byte[1024];
			int len = 0;
			while ((len = fis.read(buffer)) > 0) {
				fos.write(buffer, 0, len);
			}
		} catch (Exception e) {
			System.out.println("文件上传失败");
			e.printStackTrace();
		} finally {
			close(fos, fis);
		}
		this.goods.setImage("upfiles/" + this.getImageFileName());

		try {
			boolean result = goodsDAO.saveGoods(this.goods);
			if (result) {
				return "success";
			} else {
				return "fail";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
	}

	public String deleteGoods() {
		GoodsDAO goodsDAO = new GoodsDAO();
		try {
			boolean result = goodsDAO.deleteGoods(this.goods.getGoodsid());
			if (result) {
				return "success";
			} else {
				return "fail";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
	}

	public String updateGoods() {
		GoodsDAO goodsDAO = new GoodsDAO();
		try {
			boolean result = goodsDAO.updateGoods(this.goods);
			if (result) {
				return "success";
			} else {
				return "fail";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
	}

	public String getAllGoods() {
		GoodsDAO goodsDAO = new GoodsDAO();
		try {
			List<Goods> list = goodsDAO.queryAll();
			int temp = list.size();
			setTotalCount(list.size());
			if (pageCur <= 0) {
				pageCur = 1;
			}
			if ((pageCur - 1) * 10 >= temp) {
				pageCur = pageCur - 1;
			}
			if (temp == 0) {
				totalPage = 0;
			} else {
				totalPage = (int) Math.ceil((double) temp / 10);
			}
			goodsDAO = new GoodsDAO();
			this.setGoodsList(goodsDAO.queryByPage(pageCur));
			if (this.goodsList.size() == 0) {
				this.msg = "没有查询到数据";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
		return SUCCESS;
	}

	public String queryGoodsByCond() {
		GoodsDAO goodsDAO = new GoodsDAO();
		try {
			if ("goodsname".equals(this.cond)) {
				this.goodsList = goodsDAO.queryByLikeGoodsname(this.name);
			}
			if ("image".equals(this.cond)) {
				this.goodsList = goodsDAO.queryByLikeImage(this.name);
			}
			if ("cateid".equals(this.cond)) {
				this.goodsList = goodsDAO.queryByLikeCateid(this.name);
			}
			if ("price".equals(this.cond)) {
				this.goodsList = goodsDAO.queryByLikePrice(this.name);
			}
			if ("recommend".equals(this.cond)) {
				this.goodsList = goodsDAO.queryByLikeRecommend(this.name);
			}
			if ("special".equals(this.cond)) {
				this.goodsList = goodsDAO.queryByLikeSpecial(this.name);
			}
			if ("num".equals(this.cond)) {
				this.goodsList = goodsDAO.queryByLikeNum(this.name);
			}
			if ("sellnum".equals(this.cond)) {
				this.goodsList = goodsDAO.queryByLikeSellnum(this.name);
			}
			if ("contents".equals(this.cond)) {
				this.goodsList = goodsDAO.queryByLikeContents(this.name);
			}
			if (this.goodsList.size() == 0) {
				this.msg = "没有查询到数据";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
		return SUCCESS;
	}

	public String getGoodsById() {
		GoodsDAO goodsDAO = new GoodsDAO();
		try {
			this.goods = goodsDAO.queryById(this.goods.getGoodsid());
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
		return SUCCESS;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public List<Goods> getGoodsList() {
		return goodsList;
	}

	public void setGoodsList(List<Goods> goodsList) {
		this.goodsList = goodsList;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getPageCur() {
		return pageCur;
	}

	public void setPageCur(int pageCur) {
		this.pageCur = pageCur;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCond() {
		return cond;
	}

	public void setCond(String cond) {
		this.cond = cond;
	}

	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

	public File getImage() {
		return image;
	}

	public void setImage(File image) {
		this.image = image;
	}

	public String getImageContentType() {
		return imageContentType;
	}

	public void setImageContentType(String imageContentType) {
		this.imageContentType = imageContentType;
	}

	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}