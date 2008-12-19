/*
 * Copyright 2002-2008 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
class Attendee {
	Person person
	Event event
	Date dateCreated
	Date lastUpdated
	
	static hasMany = [talks: Talk]
	
	String toString() { "${person.username} - ${event.name}" }
	
	static constraints = {
		dateCreated(nullable:true)
		lastUpdated(nullable:true)
	}
	
	static mapping = {
		event lazy:false // lazily fetch the event
	}
}
