/*
 * This file is part of Hibernate Spatial, an extension to the
 *  hibernate ORM solution for spatial (geographic) data.
 *
 *  Copyright © 2007-2012 Geovise BVBA
 *
 *  This library is free software; you can redistribute it and/or
 *  modify it under the terms of the GNU Lesser General Public
 *  License as published by the Free Software Foundation; either
 *  version 2.1 of the License, or (at your option) any later version.
 *
 *  This library is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *  Lesser General Public License for more details.
 *
 *  You should have received a copy of the GNU Lesser General Public
 *  License along with this library; if not, write to the Free Software
 *  Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */

package org.hibernate.spatial.testing.dialects.h2geodb;

import org.hibernate.cfg.Configuration;
import org.hibernate.spatial.testing.*;
import org.hibernate.testing.junit4.BaseCoreFunctionalTestCase;

import java.io.IOException;
import java.sql.SQLException;

/**
 * @author Karel Maesen, Geovise BVBA
 *         creation-date: Oct 2, 2010
 */
public class GeoDBTestSupport extends TestSupport {


	public DataSourceUtils createDataSourceUtil(Configuration configuration) {
		super.createDataSourceUtil(configuration);
		try {
			return new GeoDBDataSourceUtils(driver(), url(), user(), passwd(), getSQLExpressionTemplate());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public TestData createTestData(BaseCoreFunctionalTestCase testcase) {
		return TestData.fromFile("h2geodb/test-geodb-data-set.xml");
	}

	public GeometryEquality createGeometryEquality() {
		return new GeoDBGeometryEquality();
	}

	public AbstractExpectationsFactory createExpectationsFactory(DataSourceUtils dataSourceUtils) {
		return new GeoDBExpectationsFactory((GeoDBDataSourceUtils) dataSourceUtils);
	}

	public SQLExpressionTemplate getSQLExpressionTemplate() {
		return new GeoDBExpressionTemplate();
	}


}

