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
package org.hibernate.spatial;

import com.vividsolutions.jts.geom.Geometry;
import org.hibernate.type.AbstractSingleColumnStandardBasicType;

/**
 * A {@link org.hibernate.type.BasicType BasicType} for JTS <code>Geometry</code>s.
 *
 * @author Karel Maesen
 */
public class GeometryType extends AbstractSingleColumnStandardBasicType<Geometry> {

	public static final GeometryType INSTANCE = new GeometryType();
	
	public static final String POINT = "Point";
	public static final String PLYGON = "Polygon";
	public static final String MULTIPOLYGON = "MultiPolygon";
	public static final String LINESTRING = "LineString";
	public static final String MULTILINESTRING = "MultiLineString";
	public static final String MULTIPOINT = "MultiPoint";
	public static final String GEOMETRYCOLLECTIOPN = "GeometryCollection";

	@Override
	public String[] getRegistrationKeys() {
		return new String[]{
				com.vividsolutions.jts.geom.Geometry.class.getCanonicalName(),
				com.vividsolutions.jts.geom.Point.class.getCanonicalName(),
				com.vividsolutions.jts.geom.Polygon.class.getCanonicalName(),
				com.vividsolutions.jts.geom.MultiPolygon.class.getCanonicalName(),
				com.vividsolutions.jts.geom.LineString.class.getCanonicalName(),
				com.vividsolutions.jts.geom.MultiLineString.class.getCanonicalName(),
				com.vividsolutions.jts.geom.MultiPoint.class.getCanonicalName(),
				com.vividsolutions.jts.geom.GeometryCollection.class.getCanonicalName(),
				"geometry"
		};
	}

	public GeometryType() {
		super(GeometrySqlTypeDescriptor.INSTANCE, GeometryJavaTypeDescriptor.INSTANCE);
	}

	@Override
	public String getName() {
		return "geometry";
	}
	
	
	public enum Type {
	    Point, Polygon, MultiPolygon, LineString, MultiLineString, MultiPoint, GeometryCollection;
	}
}
