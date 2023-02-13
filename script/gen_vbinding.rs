#!/usr/bin/env ruby

require 'erb'

def create_viewholder(name: String, bindingName: String)
  template = <<-TEMPLATE
package me.mattak.dicomparation.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import me.mattak.dicomparation.databinding.__BINDING__

class __NAME__(private val binding: __BINDING__) : RecyclerView.ViewHolder(
    binding.root
) {
    companion object {
        fun create(viewGroup: ViewGroup) = __NAME__(
            __BINDING__.inflate(
                LayoutInflater.from(viewGroup.context),
                viewGroup,
                false,
            )
        )
    }

    fun bind(cell: TextCell) {
        binding.text.text = cell.text
    }
}
    TEMPLATE

    return template.gsub(/__NAME__/, name).gsub(/__BINDING__/, bindingName)
end

def create_layout(name: String) 
  template = <<-TEMPLATE
<?xml version="1.0" encoding="utf-8"?>
<TextView xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/text"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:padding="16dp"
    android:textSize="20sp"
    android:textStyle="bold"
    tools:text="@tools:sample/lorem" />
  TEMPLATE
  return template
end

# MAIN
# ----

if ARGV.size < 1
  puts "usage: #{$0} <generate_class_count>"
  exit 0
end

generateCount = ARGV[0].to_i
rootname="appvbinding"
viewHolderDirectory = "#{rootname}/src/main/java/me/mattak/dicomparation/ui"
layoutDirectory = "#{rootname}/src/main/res/layout"
viewHolders = []
layouts = []

generateCount.times do |i|
  viewHolderName = "GeneratedCellText#{i.to_s.rjust(3, '0')}ViewHolder"
  bindingName = "GeneratedCellText#{i.to_s.rjust(3, '0')}Binding"
  content = create_viewholder(name: viewHolderName, bindingName: bindingName)
  File.write("#{viewHolderDirectory}/#{viewHolderName}.kt", content)
  viewHolders << viewHolderName

  layoutName = "generated_cell_text_#{i.to_s.rjust(3, '0')}"
  content = create_layout(name: layoutName)
  File.write("#{layoutDirectory}/#{layoutName}.xml", content)
  layouts << layoutName
end

