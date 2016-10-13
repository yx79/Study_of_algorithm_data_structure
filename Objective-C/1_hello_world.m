//
//  main.m
//  HackerRank
//
//  Created by Pomme on 10/10/16.
//  Copyright © 2016 Yuanjie Xie. All rights reserved.
//

#import <Foundation/Foundation.h>



#import <Foundation/Foundation.h>

int main(int argc, const char * argv[]) {
    @autoreleasepool {
        NSFileHandle *kbd = [NSFileHandle fileHandleWithStandardInput];
        NSData *inputData = [kbd availableData];
        NSString *option = [[[NSString alloc] initWithData:inputData
                                                  encoding:NSUTF8StringEncoding] self];
        //NSLog(@"Hello, World.\n%@",option);
        printf("Hello, World.\n%s", [option UTF8String]);
    }
    return 0;
    
    
}




