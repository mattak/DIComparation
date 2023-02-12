#!/usr/bin/env ruby

require 'erb'

def create_cell(name: String)
  template = <<-TEMPLATE
package me.mattak.dicomparation.ui.view

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun __NAME__(text: String) {
    Text(
        text = text,
        modifier = Modifier.padding(16.dp),
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
    )
}
    TEMPLATE

    return template.gsub(/__NAME__/, name)
end

# MAIN
# ----

if ARGV.size < 1
  puts "usage: #{$0} <generate_class_count>"
  exit 0
end

generateCount = ARGV[0].to_i
rootname="appcompose"
cellDirectory = "#{rootname}/src/main/java/me/mattak/dicomparation/ui/view"
cells = []

generateCount.times do |i|
  cellName = "GeneratedCellText#{i.to_s.rjust(3, '0')}"
  content = create_cell(name: cellName)
  File.write("#{cellDirectory}/#{cellName}.kt", content)
  cells << cellName
end

