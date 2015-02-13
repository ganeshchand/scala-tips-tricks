package xml

import scala.xml.XML

/**
 * Created by ganeshchand on 2/12/15.
 */
object ParseXML {
  /*
  <rss version="2.0" xmlns:atom="http://www.w3.org/2005/Atom">
  <channel>
    <title>Exchange Rates For United States Dollar</title>
    <link>http://themoneyconverter.com/USD/Exchange_Rates_For_US_Dollar.aspx</link>
    <description>RSS Exchange Rate Feed for United States Dollar</description>
    <lastBuildDate>Fri, 13 Feb 2015 02:03:17 GMT</lastBuildDate>
    <language>en-US</language>
    <copyright>Copyright: (C) The Money Converter, see http://themoneyconverter.com </copyright>
    <docs>http://themoneyconverter.com/RSSFeeds.aspx</docs>
    <ttl>61</ttl>
    <image>
      <title>Exchange Rates For United States Dollar</title>
      <url>http://themoneyconverter.com/images/TheMoneyConverter_sml.jpg</url>
      <link>http://themoneyconverter.com/USD/Exchange_Rates_For_US_Dollar.aspx</link>
    </image>
    <item>
      <title>AED/USD</title>
      <link>http://themoneyconverter.com/USD/AED.aspx</link>
      <pubDate>Fri, 13 Feb 2015 02:03:10 GMT</pubDate>
      <description>1 United States Dollar = 3.67250 United Arab Emirates Dirham</description>
      <category>Middle East</category>
    </item>
    <item>
      <title>ARS/USD</title>
      <link>http://themoneyconverter.com/USD/ARS.aspx</link>
      <pubDate>Fri, 13 Feb 2015 02:03:13 GMT</pubDate>
      <description>1 United States Dollar = 8.67123 Argentine Peso</description>
      <category>South America</category>
    </item>
    <item>
      <title>AUD/USD</title>
      <link>http://themoneyconverter.com/USD/AUD.aspx</link>
      <pubDate>Fri, 13 Feb 2015 02:03:10 GMT</pubDate>
      <description>1 United States Dollar = 1.29140 Australian Dollar</description>
      <category>Oceania</category>
   */
  def main(args: Array[String]) {
    val results = XML.load("http://themoneyconverter.com/rss-feed/USD/rss.xml")

    val title = (results \ "channel" \ "title").text
    val source = (results \ "channel" \ "link").text
    val asOfDate = (results \ "channel" \ "lastBuildDate").text
    println("Title: "+title)
    println("Source: "+ source)
    println("As Of: "+ asOfDate)

    val items = results \ "channel" \ "item"
    println("Total items found: "+items.length)

    for(i <- items){
      println((i \ "title").text + " : "+ (i \ "description").text)
    }

    val currencies =items.map(i => (i \ "title").text)
    val categories =items.map(i => (i \ "category").text)
    val descriptions =items.map(i => (i \ "description").text)

  }



}
