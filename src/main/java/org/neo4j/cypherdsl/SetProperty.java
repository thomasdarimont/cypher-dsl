/**
 * Copyright (c) 2002-2013 "Neo Technology,"
 * Network Engine for Objects in Lund AB [http://neotechnology.com]
 *
 * This file is part of Neo4j.
 *
 * Neo4j is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.neo4j.cypherdsl;

import org.neo4j.cypherdsl.expression.Expression;
import org.neo4j.cypherdsl.expression.SetExpression;

/**
 * Represents a property being assigned to a value. This is used for the SET clause,
 * as well as the MERGE ON CREATE and ON MATCH clauses.
 */
public class SetProperty
        implements AsString, SetExpression
{
    private final Property property;
    private final Expression value;

    SetProperty( Property property, Expression value )
    {
        this.property = property;
        this.value = value;
    }

    @Override
    public void asString( StringBuilder builder )
    {
        property.asString( builder );
        builder.append( '=' );
        value.asString( builder );
    }
}
