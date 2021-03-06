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

// locations to search for config files that get merged into the main config
// config files can either be Java properties files or ConfigSlurper scripts

// grails.config.locations = [ "classpath:${appName}-config.properties",
//                             "classpath:${appName}-config.groovy",
//                             "file:${userHome}/.grails/${appName}-config.properties",
//                             "file:${userHome}/.grails/${appName}-config.groovy"]

// if(System.properties["${appName}.config.location"]) {
//    grails.config.locations << "file:" + System.properties["${appName}.config.location"]
// }
grails.mime.file.extensions = true // enables the parsing of file extensions from URLs into the request format
grails.mime.types = [ html: ['text/html','application/xhtml+xml'],
                      xml: ['text/xml', 'application/xml'],
                      text: 'text-plain',
                      js: 'text/javascript',
                      rss: 'application/rss+xml',
                      atom: 'application/atom+xml',
                      css: 'text/css',
                      csv: 'text/csv',
                      all: '*/*',
                      json: ['application/json','text/json'],
                      form: 'application/x-www-form-urlencoded',
                      multipartForm: 'multipart/form-data'
                    ]
// The default codec used to encode data with ${}
grails.views.default.codec="none" // none, html, base64
grails.views.gsp.encoding="UTF-8"
grails.converters.encoding="UTF-8"

// enabled native2ascii conversion of i18n properties files
grails.enable.native2ascii = true

// set per-environment serverURL stem for creating absolute links
environments {
    production {
        grails.serverURL = "http://www.changeme.com"
    }
}

// log4j configuration
log4j {
    appender.stdout = "org.apache.log4j.ConsoleAppender"
    appender.'stdout.layout'="org.apache.log4j.PatternLayout"
    appender.'stdout.layout.ConversionPattern'='[%r] %c{2} %m%n'
    appender.stacktraceLog = "org.apache.log4j.FileAppender"
    appender.'stacktraceLog.layout'="org.apache.log4j.PatternLayout"
    appender.'stacktraceLog.layout.ConversionPattern'='[%r] %c{2} %m%n'
    appender.'stacktraceLog.File'="stacktrace.log"
    rootLogger="error,stdout"
    logger {
        grails="error"
        StackTrace="error,stacktraceLog"
        org {
            codehaus.groovy.grails.web.servlet="error"  //  controllers
            codehaus.groovy.grails.web.pages="error" //  GSP
            codehaus.groovy.grails.web.sitemesh="error" //  layouts
            codehaus.groovy.grails."web.mapping.filter"="error" // URL mapping
            codehaus.groovy.grails."web.mapping"="error" // URL mapping
            codehaus.groovy.grails.commons="info" // core / classloading
            codehaus.groovy.grails.plugins="error" // plugins
            codehaus.groovy.grails.orm.hibernate="error" // hibernate integration
            springframework="off"
            hibernate="off"
        }
    }
    additivity.StackTrace=false
}


grails {
   mail {
     host = "smtp.gmail.com"
     port = 465
     username = ""
     password = ""
     props = ["mail.smtp.auth":"true", 					   
              "mail.smtp.socketFactory.port":"465",
              "mail.smtp.socketFactory.class":"javax.net.ssl.SSLSocketFactory",
              "mail.smtp.socketFactory.fallback":"false"]
   }
}


avatarPlugin {
	defaultGravatarUrl="""http://www.ohloh.net/images/anon/anon80.gif"""
	gravatarRating="G"
}


googlemaps {
	key = "ABQIAAAAVI8tN8ZVK-n0fDPZbAvxyxQOdPk9Zpe3OjVsiMhMgz763HvImBRAhrJ2KUwZ-qDdBfmRg4ZMIsj2kg"
}


//cobertura exclusions
coverage {
	exclusions = ['**/org/grails/**',
	              '**/org/codehaus/**',
	              '**/com/synergyj/grails/plugins/**',
	              '**/de/andreasschmitt/**',
	              '**/*AccordionTagLib*/**',
	              '**/*AutoCompleteTagLib*/**',
	              '**/*CalendarTagLib*/**',
	              '**/*CarouselTagLib*/**',
	              '**/*DateChooserTagLib*/**',
	              '**/*DefaultSecurityConfig*/**',
	              '**/*FlowTagLib*/**',
	              '**/*FontImageController*/**',
	              '**/*FontImageService*/**',
	              '**/*FontTagLib*/**',
	              '**/*GoogleMapsTagLib*/**',
	              '**/*PortletTagLib*/**',
	              '**/*ProgressBarTagLib*/**',
	              '**/*RatingTagLib*/**',
	              '**/*Recaptcha*/**',
	              '**/*ReflectionImageTagLib*/**',
	              '**/*ResourceTagLib*/**',
	              '**/*RichTextEditorTagLib*/**',
	              '**/*RichUIUtilTagLib*/**',
	              '**/*RichuiConfig*/**',
	              '**/*Searchable*/**',
	              '**/*SecurityConfig*/**',
	              '**/*SetupCoetusController*/**',
	              '**/*TabViewTagLib*/**',
	              '**/*TagCloudTagLib*/**',
	              '**/*TimelineTagLib*/**',
	              '**/*TooltipTagLib*/**',
	              '**/*TreeViewTagLib*/**']
}

// The following properties have been added by the Upgrade process...
grails.views.default.codec="none" // none, html, base64
grails.views.gsp.encoding="UTF-8"
