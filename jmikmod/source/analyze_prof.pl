#!/usr/bin/perl


my (@prof_output, @last, @field_len, @temp);

open I, "./java.prof";

$_ = <I>;

while (<I>)
{
    if (/^#/)
    {
        last;
    }

    chomp $_;
    @last = split(/\s+/, $_);
    shift @last;
    push @prof_output, [@last];
}

@prof_output = sort { $a->[1] cmp $b->[1] } @prof_output;
@total_times = ( [@{$prof_output[0]}] );

for($a=1;$a<scalar(@prof_output);$a++)
{
    if ($prof_output[$a]->[1] eq $prof_output[$a-1]->[1])
    {
        
    }
}

foreach $a (@prof_output)
{
    $net_time = $a->[3];
    foreach $b (@prof_output)
    {
        
    }
}



@prof_output = sort { $b->[3] <=> $a->[3] } @prof_output;

@field_len = (0,0,0,0);

foreach $a (@prof_output)
{
    for($l=0;$l<4;$l++)
    {
        if (length($a->[$l]) > $field_len[$l])
        {
            $field_len[$l] = length($a->[$l]);
        }
    }
}



for($l=0;$l<4;$l++)
{
    $field_len[$l] += 4;
}

for($a=0;$a<scalar(@prof_output);$a++)
{
    printf("%-$field_len[0]s%-$field_len[1]s%-$field_len[2]s%-$field_len[3]s\n", @{$prof_output[$a]});
}



