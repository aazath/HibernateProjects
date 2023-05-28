package lk.iqrah.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class StudentIdGenerator implements IdentifierGenerator {

	@Override
	public Serializable generate(SharedSessionContractImplementor arg0, Object arg1) throws HibernateException {
		String date = new SimpleDateFormat("yyyy-mm-dd").format(new Date());
		int num = new Random().nextInt(5000);
		String prefix1 = "CCS-Kalmunai-";
		String prefix2 = "-Java-";
		return prefix1+date+prefix2+num;
	}

}
