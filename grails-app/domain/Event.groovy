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
class Event {
	String name
	String description
	Date startTime = new Date()
	Date endTime = new Date()
	Boolean allDay = false
	String location
	Boolean necessaryRegistry = false
	Status status = Status.PLANNING
	Boolean showStatus = true
	SortedSet tickets
	Person createdBy
	static hasMany = [talks:Talk, tickets:Ticket]
	
	static constraints = {
		name(blank:false,size:0..200)
		description(blank:true,size:0..15000)
		startTime(nullable:true)
		endTime(nullable:true)
		allDay(nullable:true)
		location(blank:true,size:0..1000)
		necessaryRegistry(nullable:true)
	}
	
	String toString() { "${name}" }
	
	def hasLocation() {
		return location?.length() > 0;
	}
	
	def mapLocation() {
		if(hasLocation()) {
			def l = location.split(",")
			return ["latitude":l[0], "longitude":l[1]]
		}
		return null;
	}
	
	def llatitude() {
		return mapLocation()["latitude"]
	}
	def llongitude() {
		return mapLocation()["longitude"]
	}
}
