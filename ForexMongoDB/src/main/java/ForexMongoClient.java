import java.util.Date;

import forex.genetic.dao.mongodb.IndividuosDAO;
import forex.genetic.dao.mongodb.MongoTendenciaParaOperarDAO;
import forex.genetic.entities.TendenciaParaOperar;
import forex.genetic.util.Constants.OperationType;
import forex.genetic.util.NumberUtil;
import forex.genetic.util.RandomUtil;

public class ForexMongoClient {

	public static void main(String[] args) {
		IndividuosDAO dao = new IndividuosDAO();
		dao.saveIndividuo();
		dao.listIndividuos("2018102516303");
		dao.listAllIndividuos();

		MongoTendenciaParaOperarDAO tpoDao = new MongoTendenciaParaOperarDAO();
		tpoDao.cleanCollection();

		for (int i = 0; i < 1500; i++) {
			TendenciaParaOperar tpo = new TendenciaParaOperar() {
				public void setSl(double sl) {
					super.sl = sl;
				}
			};
			tpo.setTipoExportacion("DFDFSD");
			tpo.setActiva(1);
			tpo.setFecha(new Date());
			tpo.setFechaBase(new Date());
			tpo.setFechaTendencia(new Date());
			if (RandomUtil.nextBoolean()) {
				tpo.setTipoOperacion(OperationType.SELL);
			} else {
				tpo.setTipoOperacion(OperationType.BUY);
			}
			tpo.setPeriodo("1440");
			tpo.setTp(NumberUtil.round(RandomUtil.nextDouble() * 500, 3));
			tpo.setSl(NumberUtil.round(RandomUtil.nextDouble() * 500, 3));
			tpo.setPrecioCalculado(NumberUtil.round(RandomUtil.nextDouble() * 2, 5));

			tpoDao.insertTendenciaParaOperar(tpo);
		}
		
		tpoDao.consultarDesviacionEstandard();
	}

}
